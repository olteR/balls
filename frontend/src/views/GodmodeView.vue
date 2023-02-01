<template>
  <div class="container mx-auto my-4">
    <div class="grid grid-cols-12 gap-4">
      <div>
        <Button
            label="import ancestries"
            @click="importStore.importAncestries()"
        ></Button>
      </div>
      <div>
        <Button
          label="import books"
          @click="importStore.importBooks()"
        ></Button>
      </div>
      <div>
        <Button
          label="import languages"
          @click="importStore.importLanguages()"
        ></Button>
      </div>
      <div>
        <Button
          label="import traits"
          @click="importStore.importTraits()"
        ></Button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useImportStore } from "@/stores/import";
import Button from "primevue/button";

const importStore = useImportStore();
</script>

<style scoped></style>
