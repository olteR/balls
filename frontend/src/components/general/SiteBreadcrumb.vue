<template>
  <Breadcrumb :home="home" :model="stateStore.getBreadcrumbs">
    <template #item="{ item }">
      <div
        @click="router.push({ name: item.name, params: item.params })"
        class="p-link"
      >
        <i v-if="item.icon" :class="item.icon" :title="item.name"></i
        ><span v-else>{{ item.label ? item.label : item.name }}</span>
      </div>
    </template>
  </Breadcrumb>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useStateStore } from "@/stores/state";
import Breadcrumb from "primevue/breadcrumb";

const router = useRouter();
const stateStore = useStateStore();
const home = ref({ icon: "pi pi-home", to: "/campaigns" });
</script>

<style scoped></style>
