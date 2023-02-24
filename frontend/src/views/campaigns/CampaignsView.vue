<template>
  <div class="container mx-auto my-4">
    <ProgressSpinner
      v-if="loading"
      aria-label="loading"
      class="fixed top-1/2 left-1/2"
    ></ProgressSpinner>
    <Accordion :multiple="true" :activeIndex="[]" v-else>
      <AccordionTab
        v-for="campaign in campaignStore.getCampaigns"
        :key="campaign.id"
        :header="campaign.name"
      >
        <div class="pt-2 mb-4">
          game master:
          {{
            campaign.relatedUsers.find((user) => user.role === "GAME_MASTER")
              .user.displayName
          }}
        </div>
        <div
          class="mb-4"
          v-if="
            campaign.relatedUsers.filter((u) => u.role === 'PLAYER').length !==
            0
          "
        >
          players:
          <span
            >{{
              campaign.relatedUsers
                .filter((u) => u.role === "PLAYER")
                .map((u) => u.user.displayName)
                .join(", ")
            }}
          </span>
        </div>
        <div
          class="mb-4"
          v-if="
            campaign.relatedUsers.filter((u) => u.role === 'SPECTATOR')
              .length !== 0
          "
        >
          spectators:
          <span
            >{{
              campaign.relatedUsers
                .filter((u) => u.role === "SPECTATOR")
                .map((u) => u.user.displayName)
                .join(", ")
            }}
          </span>
        </div>
        <div>
          <Button label="play"></Button>
          <Button
            label="campaign hub"
            @click="
              router.push({ name: 'campaign hub', params: { id: campaign.id } })
            "
          ></Button>
          <Button label="world"></Button>
        </div>
      </AccordionTab>
    </Accordion>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { useCampaignStore } from "@/stores/campaign";
import { useUserStore } from "@/stores/user";
import ProgressSpinner from "primevue/progressspinner";
import Accordion from "primevue/accordion";
import AccordionTab from "primevue/accordiontab";
import Button from "primevue/button";

const router = useRouter();
const userStore = useUserStore();
const campaignStore = useCampaignStore();
const loading = ref(true);

onMounted(() => {
  campaignStore.fetchCampaigns(userStore.getUser.id);
  loading.value = false;
});
</script>

<style scoped>
::v-deep(.p-accordion) {
  .p-accordion-header-text {
    font-size: 3rem;
    margin-bottom: 1rem;
  }
}
.p-button {
  margin-right: 1rem;
}
</style>
