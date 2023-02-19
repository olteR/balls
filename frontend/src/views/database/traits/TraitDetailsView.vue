<template>
  <Button class="backbutton" @click="router.push({ name: 'traits' })"
    ><i class="fa fa-chevron-left mr-2"></i> back to traits</Button
  >
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="!loading">
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
import { useRouter } from "vue-router";
import { useTraitStore } from "@/stores/database/trait";
import Card from "primevue/card";
import Button from "primevue/button";
import { onMounted, ref } from "vue";

const router = useRouter();
const traitStore = useTraitStore();
const loading = ref(true);

onMounted(() => {
  traitStore.fetchTrait(router.currentRoute.value.params.id);
  loading.value = false;
});
</script>

<style scoped>
.backbutton {
  margin-left: 1rem;
}
</style>
