<template>
  <Toast position="bottom-center" />
  <div v-if="router.currentRoute.value.name !== 'login'">
    <SiteMenu></SiteMenu>
  </div>
  <ProgressSpinner
    v-if="stateStore.getLoading"
    aria-label="loading"
    class="fixed top-1/2 left-1/2"
  ></ProgressSpinner>
  <div :class="{ invisible: stateStore.getLoading }">
    <RouterView />
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { RouterView, useRouter } from "vue-router";
import axios from "axios";
import { useToast } from "primevue/usetoast";
import { useStateStore } from "@/stores/state";
import Toast from "primevue/toast";
import SiteMenu from "@/components/general/SiteMenu.vue";
import ProgressSpinner from "primevue/progressspinner";

const router = useRouter();
const toast = useToast();
const stateStore = useStateStore();

onMounted(() => {
  if (!stateStore.isLoggedIn) {
    if (stateStore.getUser != null) {
      stateStore.logoutUser();
      toast.add({
        severity: "error",
        summary: "login expired",
        detail: "please log in again.",
        group: "bc",
        life: 3000,
      });
    }
    router.push("/login");
  } else {
    axios.defaults.headers.common["Authorization"] =
      "Bearer " + stateStore.getJwt;
  }
});
</script>

<style></style>
