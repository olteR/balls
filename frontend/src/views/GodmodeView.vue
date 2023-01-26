<template>
  <div class="container mx-auto my-4">
    <Button label="import books" @click="importStore.importBooks()"></Button>
    <Button label="import languages" @click="importStore.importLanguages()"></Button>
  </div>
</template>

<script setup>
import { useImportStore } from "@/stores/import";
import Button from "primevue/button";

const importStore = useImportStore();
</script>

<style scoped></style>
