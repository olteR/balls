<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
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
import { onMounted } from "vue";
import { useBookStore } from "@/stores/database/book";
import Card from "primevue/card";
import DataTable from "primevue/datatable";
import Column from "primevue/column";

const bookStore = useBookStore();

onMounted(() => {
  bookStore.fetchBooks();
});
</script>

<style scoped></style>
