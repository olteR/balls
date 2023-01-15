<template>
  <Toast />
  <RouterView />
</template>

<script setup>
import { RouterView, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import { onMounted } from "vue";
import Toast from "primevue/toast";

const userStore = useUserStore();
const router = useRouter();

onMounted(() => {
  if (userStore.getUser.value == null) {
    router.push("/login");
  }
});
</script>
