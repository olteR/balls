<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">skills</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="skillStore.getSkills"
            responsiveLayout="scroll"
            sortMode="multiple"
            removableSort
          >
            <Column field="name" header="name" :sortable="true"></Column>
            <Column field="keyAbility" header="key ability" :sortable="true">
              <template #body="slotProps">
                {{ formatAbilityScore(slotProps.data.keyAbility) }}
              </template>
            </Column>
            <Column field="source" header="source">
              <template #body="slotProps">
                {{ slotProps.data.source + " pg. " + slotProps.data.page }}
              </template>
            </Column>
            <Column>
              <template #body="slotProps">
                <router-link :to="'/database/skill/' + slotProps.data.id"
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
import { useStateStore } from "@/stores/state";
import { useSkillStore } from "@/stores/database/skill";
import { formatAbilityScore } from "@/utils/util";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const stateStore = useStateStore();
const skillStore = useSkillStore();

onMounted(async () => {
  stateStore.setLoading(true);
  await skillStore.fetchList();
  stateStore.setLoading(false);
});
</script>

<style scoped></style>
