<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="traitStore.getTrait">
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
import { onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import { useTraitStore } from "@/stores/database/trait";
import Card from "primevue/card";

const router = useRouter();
const stateStore = useStateStore();
const traitStore = useTraitStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await traitStore.fetchOne(params.id);
  stateStore.getBreadcrumbs.push({
    name: "trait",
    label: traitStore.getTrait.name,
    params: params,
  });
  stateStore.setLoading(false);
});
</script>
