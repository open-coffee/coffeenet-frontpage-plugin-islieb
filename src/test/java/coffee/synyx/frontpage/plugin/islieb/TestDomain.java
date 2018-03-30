package coffee.synyx.frontpage.plugin.islieb;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestDomain {

    static SyndFeed anySyndFeed(List<SyndEntry> entries) {
        final SyndFeed syndFeed = mock(SyndFeed.class);
        when(syndFeed.getEntries()).thenReturn(entries);
        return syndFeed;
    }

    static SyndEntry anySyndEntry(String value) {

        List<SyndContent> contents = asList(
            anySyndContent(value),
            anySyndContent("different value to '" + value + "'")
        );

        SyndEntry syndEntry = mock(SyndEntry.class);
        when(syndEntry.getContents()).thenReturn(contents);
        return syndEntry;
    }

    static SyndContent anySyndContent(String value) {
        SyndContent syndContent = mock(SyndContent.class);
        when(syndContent.getValue()).thenReturn(value);
        return syndContent;
    }

    static IsLiebRssFeedEntry anyIsLiebRssFeedEntry(String content) {
        IsLiebRssFeedEntry entry = mock(IsLiebRssFeedEntry.class);
        when(entry.getValue()).thenReturn(content);
        return entry;
    }
}
