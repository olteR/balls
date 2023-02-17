<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">ancestries</span>
      </template>
      <template #content>
        <div v-for="rarity in ANCESTRY_RARITY" :key="rarity">
          <DataTable
            :value="
              ancestryStore.getAncestries.filter(
                (a) => a.rarity.toLowerCase() === rarity
              )
            "
            responsiveLayout="scroll"
          >
            <template #header
              ><div class="text-5xl text-center">{{ rarity }}</div></template
            >
            <Column field="name" header="name"></Column>
            <Column field="source" header="source"></Column>
            <Column>
              <template #body="slotProps">
                <router-link :to="'/database/ancestry/' + slotProps.data.id"
                  ><i class="fa fa-ellipsis"></i
                ></router-link>
              </template>
            </Column>
          </DataTable>
        </div>
      </template>
    </Card>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useAncestryStore } from "@/stores/database/ancestry";
import { ANCESTRY_RARITY } from "@/utils/const";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const ancestryStore = useAncestryStore();

onMounted(() => {
  ancestryStore.fetchAncestries();
});
</script>

<style scoped></style>
