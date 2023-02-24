<template>
  <div class="container mx-auto my-4">
    <ProgressSpinner v-if="loading" aria-label="loading" class="fixed top-1/2 left-1/2"></ProgressSpinner>
    <Card class="p-4" v-else>
      <template #title>
        <span class="text-5xl">languages</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="languageStore.getLanguages"
            responsiveLayout="scroll"
            sortMode="multiple"
            removableSort
          >
            <Column field="name" header="name" :sortable="true"></Column>
            <Column field="type" header="rarity" :sortable="true">
              <template #body="slotProps">
                {{ slotProps.data.type.toLowerCase() }}
              </template>
            </Column>
            <Column field="source" header="source">
              <template #body="slotProps">
                {{ slotProps.data.source + " pg. " + slotProps.data.page }}
              </template>
            </Column>
            <Column>
              <template #body="slotProps">
                <router-link :to="'/database/language/' + slotProps.data.id"
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
import { useLanguageStore } from "@/stores/database/language";
import ProgressSpinner from 'primevue/progressspinner';
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const languageStore = useLanguageStore();
const loading = ref(true);

onMounted(() => {
  languageStore.fetchLanguages();
  loading.value = false;
});
</script>

<style scoped></style>
