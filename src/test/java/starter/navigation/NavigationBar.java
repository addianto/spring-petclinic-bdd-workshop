package starter.navigation;

import net.serenitybdd.screenplay.targets.Target;

public class NavigationBar {

    public static final Target HOME_NAV = Target
            .the("home navigation")
            .locatedBy("//a[@routerlink='welcome']");

    public static final Target OWNERS_MENU = Target
            .the("owners menu")
            .locatedBy("//nav/div/ul/li[2]");
    public static final Target SEARCH_OWNER_BUTTON = Target
            .the("search owner navigation")
            .locatedBy("//a[@routerlink='/owners']");

    public static final Target NEW_OWNER_BUTTON = Target
            .the("new owner navigation")
            .locatedBy("//a[@routerlink='/owners/add']");
}
