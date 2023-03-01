<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="languageStore.getLanguage">
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
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import { useLanguageStore } from "@/stores/database/language";
import Card from "primevue/card";
import Button from "primevue/button";

const router = useRouter();
const stateStore = useStateStore();
const languageStore = useLanguageStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await languageStore.fetchLanguage(params.id);
  stateStore.getBreadcrumbs.push({
    name: "language",
    label: languageStore.getLanguage.name,
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
