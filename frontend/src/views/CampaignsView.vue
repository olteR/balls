<template>
  <div class="container mx-auto my-4">
    <Panel
      v-for="campaign in campaignStore.campaigns"
      :key="campaign.id"
      :header="campaign.name"
      toggleable
      collapsed
      class="my-4"
    >
      <div class="pt-2 mb-4">
        game master: {{ campaign.relatedUsers.find(user => user.role === 'GAME_MASTER').user.displayName
        }}<span class="ml-8">ruleset: {{ campaign.ruleset.shortName }}</span>
      </div>
      <div class="mb-4">
        players:
        <span v-for="user in campaign.relatedUsers.filter(user => user.role === 'PLAYER')" :key="user.id"
          >{{ user.user.displayName }} as {{ user.characters[0].name
          }}<span
            v-if="
              campaign.relatedUsers.indexOf(user) !==
              campaign.relatedUsers.length - 1
            "
            >,
          </span>
        </span>
      </div>
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
import Button from "primevue/button";

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
