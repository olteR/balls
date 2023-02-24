<template>
  <div class="container mx-auto my-4">
    <div class="grid grid-cols-4 gap-4">
      <div>
        <Button
          label="import ancestries & heritages"
          @click="importAncestries()"
          :loading="loadingAncestries"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import books"
          @click="importBooks()"
          :loading="loadingBooks"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import languages"
          @click="importLanguages()"
          :loading="loadingLanguages"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import traits"
          @click="importTraits()"
          :loading="loadingTraits"
          class="w-full"
        ></Button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useImportStore } from "@/stores/import";
import Button from "primevue/button";

const importStore = useImportStore();
const loadingAncestries = ref(false);
const loadingBooks = ref(false);
const loadingLanguages = ref(false);
const loadingTraits = ref(false);

async function importAncestries() {
  loadingAncestries.value = true;
  await importStore.importAncestries();
  loadingAncestries.value = false;
}
async function importBooks() {
  loadingBooks.value = true;
  await importStore.importBooks();
  loadingBooks.value = false;
}
async function importLanguages() {
  loadingLanguages.value = true;
  await importStore.importLanguages();
  loadingLanguages.value = false;
}
async function importTraits() {
  loadingTraits.value = true;
  await importStore.importTraits();
  loadingTraits.value = false;
}
</script>

<style scoped></style>
