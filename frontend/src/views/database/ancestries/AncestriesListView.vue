<template>
  <div class="container mx-auto my-4">
    <ProgressSpinner
      v-if="loading"
      aria-label="loading"
      class="fixed top-1/2 left-1/2"
    ></ProgressSpinner>
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">ancestries</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="ancestryStore.getAncestries"
            responsiveLayout="scroll"
            sortMode="multiple"
            removableSort
          >
            <Column field="name" header="name" :sortable="true"></Column>
            <Column field="rarity" header="rarity" :sortable="true">
              <template #body="slotProps">
                {{ slotProps.data.rarity.toLowerCase() }}
              </template>
            </Column>
            <Column field="source" header="source">
              <template #body="slotProps">
                {{ slotProps.data.source + " pg. " + slotProps.data.page }}
              </template>
            </Column>
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
import { onMounted, ref } from "vue";
import { useAncestryStore } from "@/stores/database/ancestry";
import ProgressSpinner from "primevue/progressspinner";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const ancestryStore = useAncestryStore();
const loading = ref(true);

onMounted(() => {
  ancestryStore.fetchAncestries();
  loading.value = false;
});
</script>

<style scoped></style>
