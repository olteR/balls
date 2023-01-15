<template>
  <Toast />
  <div class="card">
    <TabMenu v-if="isLoggedIn" :model="items" />
    <RouterView />
  </div>
</template>

<script setup>
import { RouterView, useRouter } from "vue-router";
import { useUserStore } from "@/stores/user";
import {onMounted, ref, computed} from "vue";
import Toast from "primevue/toast";
import TabMenu from "primevue/tabmenu";

const userStore = useUserStore();
const router = useRouter();
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

const isLoggedIn = computed(() => userStore.getUser.value != null)

onMounted(() => {
  if (localStorage.getItem("jwt") != null) {
    userStore.refreshUser(localStorage.getItem("jwt"));
  } else {
    router.push("/login");
  }
});
</script>
