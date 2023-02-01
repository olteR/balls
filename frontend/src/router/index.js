import { createRouter, createWebHistory } from "vue-router";
import LoginView from "../views/LoginView.vue";
import CampaignsView from "../views/campaigns/CampaignsView.vue";
import CampaignHub from "@/views/campaigns/CampaignHub.vue";
import CharactersView from "../views/CharactersView.vue";
import DatabaseView from "../views/database/DatabaseView.vue";
import ProfileView from "../views/ProfileView.vue";
import GodmodeView from "../views/GodmodeView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    // CAMPAIGNS
    {
      path: "/campaigns",
      name: "campaigns",
      component: CampaignsView,
    },
    {
      path: "/campaigns/:id?/hub",
      name: "campaign hub",
      component: CampaignHub,
    },
    {
      path: "/characters",
      name: "characters",
      component: CharactersView,
    },
    {
      path: "/database",
      name: "database",
      component: DatabaseView,
    },
    {
      path: "/profile",
      name: "profile",
      component: ProfileView,
    },
    {
      path: "/godmode",
      name: "godmode",
      component: GodmodeView,
    },
    {
      path: "/",
      redirect: () => {
        return "campaigns";
      },
    },
  ],
});

export default router;
