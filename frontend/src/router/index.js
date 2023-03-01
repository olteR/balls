import { createRouter, createWebHistory } from "vue-router";
import { useStateStore } from "@/stores/state";
// GENERAL
import LoginView from "../views/LoginView.vue";
import ProfileView from "../views/ProfileView.vue";
import GodmodeView from "../views/GodmodeView.vue";
// CAMPAIGNS
import CampaignsView from "../views/campaigns/CampaignsView.vue";
import CampaignHub from "@/views/campaigns/CampaignHub.vue";
// CHARACTERS
import CharactersView from "../views/characters/CharactersView.vue";
// DATABASE
import DatabaseView from "../views/database/DatabaseView.vue";
import AncestriesListView from "../views/database/ancestries/AncestriesListView.vue";
import AncestryDetailsView from "@/views/database/ancestries/AncestryDetailsView.vue";
import BooksListView from "@/views/database/books/BooksListView.vue";
import BookDetailsView from "@/views/database/books/BookDetailsView.vue";
import LanguagesListView from "@/views/database/languages/LanguagesListView.vue";
import LanguageDetailsView from "@/views/database/languages/LanguageDetailsView.vue";
import TraitsListView from "@/views/database/traits/TraitsListView.vue";
import TraitDetailsView from "@/views/database/traits/TraitDetailsView.vue";

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
      props: { breadcrumbs: [{ name: "profile" }] },
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
      props: { breadcrumbs: [{ name: "campaigns" }] },
    },
    {
      path: "/campaigns/:id?/hub",
      name: "campaign hub",
      component: CampaignHub,
      props: { breadcrumbs: [{ name: "campaigns" }] },
    },
    // CHARACTERS
    {
      path: "/characters",
      name: "characters",
      component: CharactersView,
      props: { breadcrumbs: [{ name: "characters" }] },
    },
    // DATABASE
    {
      path: "/database",
      name: "database",
      component: DatabaseView,
      props: { breadcrumbs: [{ name: "database" }] },
    },
    {
      path: "/database/ancestries",
      name: "ancestries",
      component: AncestriesListView,
      props: { breadcrumbs: [{ name: "database" }, { name: "ancestries" }] },
    },
    {
      path: "/database/ancestry/:id?",
      name: "ancestry",
      component: AncestryDetailsView,
      props: { breadcrumbs: [{ name: "database" }, { name: "ancestries" }] },
    },
    {
      path: "/database/books",
      name: "books",
      component: BooksListView,
      props: { breadcrumbs: [{ name: "database" }, { name: "books" }] },
    },
    {
      path: "/database/book/:id?",
      name: "book",
      component: BookDetailsView,
      props: { breadcrumbs: [{ name: "database" }, { name: "books" }] },
    },
    {
      path: "/database/languages",
      name: "languages",
      component: LanguagesListView,
      props: { breadcrumbs: [{ name: "database" }, { name: "languages" }] },
    },
    {
      path: "/database/language/:id?",
      name: "language",
      component: LanguageDetailsView,
      props: { breadcrumbs: [{ name: "database" }, { name: "languages" }] },
    },
    {
      path: "/database/traits",
      name: "traits",
      component: TraitsListView,
      props: { breadcrumbs: [{ name: "database" }, { name: "traits" }] },
    },
    {
      path: "/database/trait/:id?",
      name: "trait",
      component: TraitDetailsView,
      props: { breadcrumbs: [{ name: "database" }, { name: "traits" }] },
    },

    {
      path: "/",
      redirect: () => {
        return "campaigns";
      },
    },
  ],
});
router.beforeEach((to) => {
  const stateStore = useStateStore();
  const breadcrumbs = [].concat(to.matched[0].props.default.breadcrumbs);
  stateStore.setBreadcrumbs(breadcrumbs);
});
export default router;
