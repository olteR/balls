<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="bookStore.getBook">
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
import { onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import { useBookStore } from "@/stores/database/book";
import Card from "primevue/card";

const router = useRouter();
const stateStore = useStateStore();
const bookStore = useBookStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await bookStore.fetchOne(params.id);
  stateStore.getBreadcrumbs.push({
    name: "book",
    label: bookStore.getBook.name,
    params: params,
  });
  stateStore.setLoading(false);
});
</script>

<style scoped>
.backbutton {
  margin-left: 1rem;
}
</style>
