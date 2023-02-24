<template>
  <Button class="backbutton" @click="router.push({ name: 'books' })"
    ><i class="fa fa-chevron-left mr-2"></i> back to books</Button
  >
  <div class="container mx-auto my-4">
    <ProgressSpinner
      v-if="loading"
      aria-label="loading"
      class="fixed top-1/2 left-1/2"
    ></ProgressSpinner>
    <Card class="p-4" v-else>
      <template #title>
        <div class="text-5xl">
          {{ bookStore.getBook.name }}
        </div>
      </template>
      <template #content> </template>
    </Card>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { useBookStore } from "@/stores/database/book";
import ProgressSpinner from "primevue/progressspinner";
import Card from "primevue/card";
import Button from "primevue/button";

const router = useRouter();
const bookStore = useBookStore();
const loading = ref(true);

onMounted(() => {
  bookStore.fetchBook(router.currentRoute.value.params.id);
  loading.value = false;
});
</script>

<style scoped>
.backbutton {
  margin-left: 1rem;
}
</style>
