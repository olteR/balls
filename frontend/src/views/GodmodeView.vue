<template>
  <div class="container mx-auto my-4">
    <Button label="import races" @click="importRaces"></Button>
  </div>
</template>

<script setup>
import { useImportStore } from "@/stores/import";
import Button from "primevue/button";

const importStore = useImportStore();
function importRaces() {
  importStore.importRaces();
}
</script>

<style scoped></style>
