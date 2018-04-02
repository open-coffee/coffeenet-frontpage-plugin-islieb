package coffee.synyx.frontpage.plugin.islieb;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

class IsLiebRssFeedEntry {

    private final SyndEntry entry;

    IsLiebRssFeedEntry(SyndEntry entry) {
        this.entry = entry;
    }

    String getTitle() {
        return entry.getTitle();
    }

    Element getImage() {
        final List<SyndContent> contents = entry.getContents();
        final String rssFeedContentHtml = contents.get(0).getValue();
        final Document rssFeed = Jsoup.parse(rssFeedContentHtml);

        return rssFeed.select("img").get(0);
    }
}
