<template>
  <div class="container mx-auto my-4">
    <Panel v-for="campaign in campaignStore.campaigns" :key="campaign.id" :header="campaign.name" toggleable collapsed class="my-4">
      <div class="mb-4">game master: {{ campaign.gameMaster.name }}</div>
      <div class="mb-4">players: <span v-for="character in campaign.characters">{{ character.owner.name }} as {{ character.name }}<span v-if="campaign.characters.indexOf(character) !== campaign.characters.length - 1">, </span> </span></div>
      <div>
        <Button label="play"></Button>
        <Button label="campaign hub"></Button>
        <Button label="world"></Button>
      </div>
    </Panel>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useCampaignStore } from "@/stores/campaign";
import { useUserStore } from "@/stores/user";
import Panel from "primevue/panel";
import Button from 'primevue/button';

const userStore = useUserStore();
const campaignStore = useCampaignStore();

onMounted(() => {
  campaignStore.fetchCampaigns(userStore.getUser.id);
});
</script>

<style scoped>
::v-deep(.p-panel) {
  .p-panel-title {
    font-size: 3rem;
    margin-bottom: 1rem;
  }
}
.p-button {
  margin-right: 1rem;
}
</style>
