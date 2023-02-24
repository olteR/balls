<template>
  <div class="container mx-auto my-4">
    <ProgressSpinner
      v-if="loading"
      aria-label="loading"
      class="fixed top-1/2 left-1/2"
    ></ProgressSpinner>
    <Card class="p-4" v-else>
      <template #title>
        <span class="text-5xl">books</span>
      </template>
      <template #content>
        <div>
          <DataTable
            :value="bookStore.getBooks"
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
                <router-link :to="'/database/book/' + slotProps.data.id"
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
import { useBookStore } from "@/stores/database/book";
import ProgressSpinner from "primevue/progressspinner";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const bookStore = useBookStore();
const loading = ref(true);

onMounted(() => {
  bookStore.fetchBooks();
  loading.value = false;
});
</script>

<style scoped></style>
