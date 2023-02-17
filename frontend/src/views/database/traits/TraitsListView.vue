<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">traits</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="traitStore.getTraits"
            responsiveLayout="scroll"
            sortMode="multiple"
            removableSort
          >
            <Column field="name" header="name" :sortable="true"></Column>
            <Column>
              <template #body="slotProps">
                <router-link :to="'/database/trait/' + slotProps.data.id"
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
import { useTraitStore } from "@/stores/database/trait";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const traitStore = useTraitStore();

onMounted(() => {
  traitStore.fetchTraits();
});
</script>

<style scoped></style>
