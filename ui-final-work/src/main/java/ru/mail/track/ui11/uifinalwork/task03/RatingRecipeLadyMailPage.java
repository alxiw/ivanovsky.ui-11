package ru.mail.track.ui11.uifinalwork.task03;

import ru.mail.track.ui11.selenidetestcore.navigation.*;

import java.util.List;

@UrlPattern("http[s]?://lady.mail.ru/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/")
@PageUrlPath({
        @Path(name = "new", parameter = "/recipe/%1/%2/")
})
@Domain("https://lady.mail.ru/")
public class RatingRecipeLadyMailPage extends AbstractRecipeLadyMailPage<RatingRecipeLadyMailPage> {

    public RatingRecipeLadyMailPage() {
        super();
    }

    public RatingRecipeLadyMailPage(List recipes) {
        super(recipes);
    }
}
