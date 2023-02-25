<template>
  <Button class="backbutton" @click="router.push({ name: 'traits' })"
    ><i class="fa fa-chevron-left mr-2"></i> back to traits</Button
  >
  <div class="container mx-auto my-4">
    <ProgressSpinner
      v-if="loading"
      aria-label="loading"
      class="fixed top-1/2 left-1/2"
    ></ProgressSpinner>
    <Card class="p-4" v-else>
      <template #title>
        <div class="text-5xl">
          {{ traitStore.getTrait.name }}
        </div>
      </template>
      <template #content> </template>
    </Card>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { useTraitStore } from "@/stores/database/trait";
import ProgressSpinner from "primevue/progressspinner";
import Card from "primevue/card";
import Button from "primevue/button";

const router = useRouter();
const traitStore = useTraitStore();
const loading = ref(true);

onMounted(async () => {
  await traitStore.fetchTrait(router.currentRoute.value.params.id);
  loading.value = false;
});
</script>

<style scoped>
.backbutton {
  margin-left: 1rem;
}
</style>
