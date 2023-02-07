<template>
  <div class="container mx-auto my-4">
    <Card class="p-4">
      <template #title>
        <span class="text-5xl">ancestry</span>
      </template>
    </Card>
  </div>
</template>

<script setup>
import {onMounted} from "vue";
import {useRouter} from "vue-router";
import {useAncestryStore} from "@/stores/database/ancestry";

const router = useRouter();
const ancestryStore = useAncestryStore();
onMounted(() => {
  ancestryStore.fetchAncestry(router.currentRoute.value.params.id);
})
</script>

<style scoped>

</style>