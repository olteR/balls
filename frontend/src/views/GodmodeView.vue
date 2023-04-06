<template>
  <div class="container mx-auto my-4">
    <div class="grid grid-cols-2 xl:grid-cols-4 gap-4">
      <div>
        <Button
            label="import abilities"
            @click="importEntity('ABILITIES')"
            :loading="loading.ABILITIES"
            class="w-full"
            disabled
        ></Button>
      </div>
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
            label="import backgrounds"
            @click="importEntity('BACKGROUNDS')"
            :loading="loading.BACKGROUNDS"
            class="w-full"
            disabled
        ></Button>
      </div>
      <div>
        <Button
            label="import classes"
            @click="importEntity('CLASSES')"
            :loading="loading.CLASSES"
            class="w-full"
            disabled
        ></Button>
      </div>
      <div>
        <Button
            label="import conditions"
            @click="importEntity('CONDITIONS')"
            :loading="loading.CONDITIONS"
            class="w-full"
            disabled
        ></Button>
      </div>
      <div>
        <Button
            label="import feats"
            @click="importEntity('FEATS')"
            :loading="loading.FEATS"
            class="w-full"
            disabled
        ></Button>
      </div>
      <div>
        <Button
            label="import items"
            @click="importEntity('ITEMS')"
            :loading="loading.ITEMS"
            class="w-full"
            disabled
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
          label="import sources"
          @click="importEntity('SOURCES')"
          :loading="loading.SOURCES"
          class="w-full"
        ></Button>
      </div>
      <div>
        <Button
            label="import spells"
            @click="importEntity('SPELLS')"
            :loading="loading.SPELLS"
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
  ABILITIES: false,
  ACTIONS: false,
  ANCESTRIES: false,
  BACKGROUNDS: false,
  CLASSES: false,
  CONDITIONS: false,
  FEATS: false,
  ITEMS: false,
  LANGUAGES: false,
  SOURCES: false,
  SPELLS: false,
  TRAITS: false,
});

async function importEntity(entity) {
  loading.value[entity] = true;
  await importStore.importEntity[entity]();
  loading.value[entity] = false;
}
</script>
