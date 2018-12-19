package ru.mail.track.ui11.uifinalwork.task03;

import ru.mail.track.ui11.selenidetestcore.navigation.*;

import java.util.List;

@UrlPattern("http[s]?://lady.mail.ru/[\\w_\\-]+/[\\w_\\-]+/")
@PageUrlPath({
        @Path(name = "new", parameter = "/recipe/%1/")
})
@Domain("https://lady.mail.ru/")
public class RecipeLadyMailPage extends AbstractRecipeLadyMailPage<RecipeLadyMailPage> {

    public RecipeLadyMailPage() {
        super();
    }

    public RecipeLadyMailPage(List recipes) {
        super(recipes);
    }
}
