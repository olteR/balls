<template>
  <Toast />
  <div class="card">
    <div v-if="router.currentRoute.value.name !== 'login'">
      <TabMenu :model="items" class="inline" />
      <span class="tab-menu-profile"
        >logged in as {{ userStore.getUser ? userStore.getUser.name : ""}}. <i class="fa fa-user"></i
      ></span>
    </div>
    <RouterView />
  </div>
</template>

<script setup>
import { RouterView, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import {onMounted, ref, watch} from "vue";
import Toast from "primevue/toast";
import TabMenu from "primevue/tabmenu";
import { useToast } from "primevue/usetoast";
import axios from "axios";

const router = useRouter();
const toast = useToast();
const userStore = useUserStore();
const items = ref([
  {
    label: "campaigns",
    to: "/campaigns",
  },
  {
    label: "characters",
    to: "/characters",
  },
  {
    label: "database",
    to: "/database",
  },
]);

onMounted(() => {
  if (!userStore.isLoggedIn) {
    if (userStore.getUser != null) {
      userStore.logoutUser();
      toast.add({
        severity: "error",
        summary: "login expired",
        detail: "please log in again.",
        life: 3000,
      });
    }
    router.push("/login");
  } else {
    axios.defaults.headers.common["Authorization"] =
      "Bearer " + userStore.getJwt;
  }
});
</script>

<style>
.tab-menu-profile {
  position: fixed;
  top: 0;
  right: 0;
  padding: 0.75rem 1.25rem;
}
</style>
