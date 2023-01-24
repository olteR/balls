<template>
  <div class="container mx-auto my-4">
    <Button label="import books" @click="importBooks"></Button>
  </div>
</template>

<script setup>
import { useImportStore } from "@/stores/import";
import Button from "primevue/button";

const importStore = useImportStore();
function importBooks() {
  importStore.importBooks();
}
</script>

<style scoped></style>
