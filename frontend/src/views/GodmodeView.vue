<template>
  <div class="container mx-auto my-4">
    <div class="grid grid-cols-2 xl:grid-cols-4 gap-4">
      <div>
        <Button
          label="import actions"
          @click="importEntity('ACTIONS')"
          :loading="loading.ACTIONS"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import ancestries & heritages"
          @click="importEntity('ANCESTRIES')"
          :loading="loading.ANCESTRIES"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import books"
          @click="importEntity('BOOKS')"
          :loading="loading.BOOKS"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import languages"
          @click="importEntity('LANGUAGES')"
          :loading="loading.LANGUAGES"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
          label="import traits"
          @click="importEntity('TRAITS')"
          :loading="loading.TRAITS"
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
const loading = ref({
  ACTIONS: false,
  ANCESTRIES: false,
  BOOKS: false,
  LANGUAGES: false,
  TRAITS: false,
});

async function importEntity(entity) {
  loading.value[entity] = true;
  await importStore.importEntity[entity]();
  loading.value[entity] = false;
}
</script>

<style scoped></style>
