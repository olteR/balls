import { createRouter, createWebHistory } from "vue-router";
import LoginView from "../views/LoginView.vue";
import CampaignsView from "../views/CampaignsView.vue";
import CharactersView from "../views/CharactersView.vue";
import DatabaseView from "../views/DatabaseView.vue";
import GodmodeView from "../views/GodmodeView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: "/campaigns",
      name: "campaigns",
      component: CampaignsView,
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
