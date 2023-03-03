<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">sources</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="sourceStore.getSources"
            responsiveLayout="scroll"
            sortMode="multiple"
            removableSort
          >
            <Column field="name" header="name" :sortable="true"></Column>
            <Column
              field="shortName"
              header="abbreviation"
              :sortable="true"
            ></Column>
            <Column
              field="published"
              header="published"
              :sortable="true"
            ></Column>
            <Column>
              <template #body="slotProps">
                <router-link :to="'/database/source/' + slotProps.data.id"
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
import { useSourceStore } from "@/stores/database/source";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const stateStore = useStateStore();
const sourceStore = useSourceStore();

onMounted(async () => {
  stateStore.setLoading(true);
  await sourceStore.fetchList();
  stateStore.setLoading(false);
});
</script>
