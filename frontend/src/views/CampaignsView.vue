<template>
  <div class="container mx-auto my-4">
    <Panel>
      <h3></h3>
    </Panel>
  </div>
</template>

<script setup>
import Panel from "primevue/panel";
import { onMounted } from "vue";
import { useCampaignStore } from "@/stores/campaign";
import { useUserStore } from "@/stores/user";

const userStore = useUserStore();
const campaignStore = useCampaignStore();

onMounted(() => {
  campaignStore.fetchCampaigns(userStore.getUser.id);
});
</script>

<style scoped></style>
