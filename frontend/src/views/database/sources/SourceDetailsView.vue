<template>
  <div class="container mx-auto my-4">
    <Card class="p-4" v-if="sourceStore.getSource">
      <template #title>
        <div class="text-5xl">
          {{ sourceStore.getSource.name }}
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
import { useSourceStore } from "@/stores/database/source";
import Card from "primevue/card";

const router = useRouter();
const stateStore = useStateStore();
const sourceStore = useSourceStore();

onMounted(async () => {
  stateStore.setLoading(true);
  const params = router.currentRoute.value.params;
  await sourceStore.fetchOne(params.id);
  stateStore.getBreadcrumbs.push({
    name: "source",
    label: sourceStore.getSource.name,
    params: params,
  });
  stateStore.setLoading(false);
});
</script>
