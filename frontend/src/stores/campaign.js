import { computed, ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import { useToast } from "primevue/usetoast";

export const useCampaignStore = defineStore("campaign", () => {
  const toast = useToast();

  const campaignDetails = ref();
  const campaigns = ref([]);

  const getCampaign = computed(() => campaignDetails.value);
  const getCampaigns = computed(() => campaigns.value);

  const urls = {
    campaign: "http://localhost:3000/api/campaign",
    campaigns: "http://localhost:3000/api/campaigns",
  };

  async function fetchCampaign(id) {
    try {
      const response = await axios.get(urls.campaign + "/" + id);
      campaignDetails.value = response.data;
    } catch (error) {
      toast.add({
        severity: "error",
        summary: "error.",
        detail: error,
        life: 3000,
      });
    }
  }

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

  return {
    getCampaign,
    getCampaigns,
    fetchCampaign,
    fetchCampaigns,
  };
});
