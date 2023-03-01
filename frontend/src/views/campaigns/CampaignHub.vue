<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="campaignStore.getCampaign">
      <template #title>
        <span class="text-5xl">{{ campaignStore.getCampaign.name }}</span>
      </template>
      <template #subtitle>
        {{ campaignStore.getCampaign.description }}
      </template>
      <template #content>
        <Panel
          v-for="user in campaignStore.getCampaign.relatedUsers"
          :key="user.user.id"
          :toggleable="user.role === 'PLAYER'"
          collapsed
        >
          <template #header>
            <span class="text-3xl"
              ><i v-if="user.role === 'PLAYER'" class="fa fa-gamepad"></i
              ><i
                v-else-if="user.role === 'GAME_MASTER'"
                class="fa fa-crown"
              ></i
              ><i v-else class="fa fa-binoculars"></i>
              {{ user.user.displayName }}</span
            >
          </template>
          <DataTable :value="user.characters" responsiveLayout="scroll">
            <template #header>characters</template>
            <Column field="name" header="name"></Column>
            <Column field="level" header="level"></Column>
            <Column field="ancestry.name" header="ancestry"></Column>
            <Column field="characterClass.name" header="class"></Column>
          </DataTable>
        </Panel>
      </template>
    </Card>
    <Card class="p-4 mt-4" v-if="!loading">
      <template #title>
        <span class="text-5xl">featured articles</span>
      </template>
    </Card>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import { useCampaignStore } from "@/stores/campaign";
import Card from "primevue/card";
import Panel from "primevue/panel";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const router = useRouter();
const stateStore = useStateStore();
const campaignStore = useCampaignStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await campaignStore.fetchCampaign(params.id);
  stateStore.getBreadcrumbs.push({
    name: "campaign hub",
    label: campaignStore.getCampaign.name,
    params: params,
  });
  stateStore.setLoading(false);
});
</script>

<style scoped>
::v-deep(.p-datatable) {
  .p-datatable-header {
    font-size: 1.875rem;
    text-align: center;
  }
}
</style>
