import { createRouter, createWebHistory } from "vue-router";
// GENERAL
import LoginView from "../views/LoginView.vue";
import ProfileView from "../views/ProfileView.vue";
import GodmodeView from "../views/GodmodeView.vue";
// CAMPAIGNS
import CampaignsView from "../views/campaigns/CampaignsView.vue";
import CampaignHub from "@/views/campaigns/CampaignHub.vue";
// CHARACTERS
import CharactersView from "../views/CharactersView.vue";
// DATABASE
import DatabaseView from "../views/database/DatabaseView.vue";
import AncestriesListView from "../views/database/ancestries/AncestriesListView.vue";
import AncestryDetailsView from "@/views/database/ancestries/AncestryDetailsView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // GENERAL
    {
      path: "/login",
      name: "login",
      component: LoginView,
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
    // CHARACTERS
    {
      path: "/characters",
      name: "characters",
      component: CharactersView,
    },
    // DATABASE
    {
      path: "/database",
      name: "database",
      component: DatabaseView,
    },
    {
      path: "/database/ancestries",
      name: "ancestries",
      component: AncestriesListView,
    },
    {
      path: "/database/ancestry/:id?",
      name: "ancestry",
      component: AncestryDetailsView,
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
