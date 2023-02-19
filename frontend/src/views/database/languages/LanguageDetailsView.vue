<template>
  <Button class="backbutton" @click="router.push({ name: 'languages' })"
    ><i class="fa fa-chevron-left mr-2"></i> back to languages</Button
  >
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="!loading">
      <template #title>
        <div class="text-5xl">
          {{ languageStore.getLanguage.name }}
        </div>
      </template>
      <template #content>
        <div
          v-if="languageStore.getLanguage.description"
          v-html="languageStore.getLanguage.description"
        ></div>
        <div v-if="languageStore.getLanguage.typicalSpeakers">
          <div class="text-3xl pt-4">typical speakers</div>
          <div>
            <span
              v-for="speaker in languageStore.getLanguage.typicalSpeakers"
              :key="speaker.name"
              ><router-link
                v-if="speaker.id"
                :to="'/database/ancestry/' + speaker.id"
                class="p-link"
                >{{ speaker.name }}</router-link
              ><span v-else>{{ speaker.name }}</span
              ><span
                v-if="
                  languageStore.getLanguage.typicalSpeakers.indexOf(speaker) +
                    1 !==
                  languageStore.getLanguage.typicalSpeakers.length
                "
                >,
              </span></span
            >
          </div>
          <div v-if="languageStore.getLanguage.ancestriesKnowing.length > 0">
            <div class="text-3xl pt-4">ancestries knowing</div>
            <span
              v-for="ancestry in languageStore.getLanguage.ancestriesKnowing"
              :key="ancestry.id"
              ><router-link
                :to="'/database/ancestry/' + ancestry.id"
                class="p-link"
                >{{ ancestry.name }}</router-link
              ><span
                v-if="
                  languageStore.getLanguage.ancestriesKnowing.indexOf(
                    ancestry
                  ) +
                    1 !==
                  languageStore.getLanguage.ancestriesKnowing.length
                "
                >,
              </span></span
            >
          </div>
          <div class="pt-4 text-right">
            <div class="font-bold">source</div>
            <div>
              {{
                languageStore.getLanguage.source +
                " pg. " +
                languageStore.getLanguage.page
              }}
            </div>
          </div>
        </div>
      </template>
    </Card>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { useLanguageStore } from "@/stores/database/language";
import Card from "primevue/card";
import Button from "primevue/button";
import { onMounted, ref } from "vue";

const router = useRouter();
const languageStore = useLanguageStore();
const loading = ref(true);

onMounted(() => {
  languageStore.fetchLanguage(router.currentRoute.value.params.id);
  loading.value = false;
});
</script>

<style scoped>
.backbutton {
  margin-left: 1rem;
}
</style>
