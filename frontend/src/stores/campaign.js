import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useCampaignStore = defineStore("campaign", () => {
  const toast = useToast();

  const campaigns = ref([]);

  const getCampaigns = computed(() => campaigns);

  const urls = {
    campaigns: "http://localhost:3000/api/campaigns",
  };

  async function fetchCampaigns(userId) {
    try {
      const response = await axios.get(urls.campaigns + "/" + userId);
      campaigns.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

  return { campaigns, getCampaigns, fetchCampaigns };
});
