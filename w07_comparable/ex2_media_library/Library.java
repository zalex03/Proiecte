package teme.w07_comparable.ex2_media_library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Library {


    //TODO: add fields..
    List<MediaEntity> top20Media = new ArrayList<>();
    List<MediaEntity> holdMedia = new ArrayList<>();


    public Library() {
        super();
    }

    public List<MediaEntity> getTop20() {


        holdMedia.sort(MediaEntity::compareTo);
        for (int i = holdMedia.size() - 1; i >= 0; i--) {
            if (top20Media.size()==20) {
                break;
            }
            top20Media.add(holdMedia.get(i));


        }

        return top20Media;
    }

    public List<MediaEntity> getArchive() {

        List<MediaEntity> archiveMedia = new ArrayList<>();
        if (getTop20().size() < 20) {
            return archiveMedia;
        }
        holdMedia.sort(MediaEntity::compareTo);
        archiveMedia.addAll(holdMedia.subList(0, holdMedia.size() - 20));
        //reversed order using Collection.sort//Collections.reverseOrder
        Collections.sort(archiveMedia, Collections.reverseOrder());
        return archiveMedia;
    }

    void addMedia(MediaEntity... medias) { //using varargs params, you can handle 'medias' as an array of MediaEntity objects inside the function
        for (MediaEntity search : medias
        ) {
            holdMedia.add(search);
            System.out.println("Hello  " + search);
        }
        System.out.println(" " + medias);
    }

    List<MediaEntity> findByType(MediaType type) {
        List<MediaEntity> listByType = new ArrayList<>();
        for (MediaEntity search : holdMedia
        ) {
            if (search.getType() == type) {
                listByType.add(search);
            }

        }
        listByType.sort(MediaEntity::compareTo);
        Collections.sort(listByType, Collections.reverseOrder());
        return listByType;
    }

    List<MediaEntity> findByTitle(String title) {
        List<MediaEntity> listByTitle = new ArrayList<>();
        for (MediaEntity search : holdMedia
        ) {
            if (search.getTitle() == title) {
                listByTitle.add(search);
            }

        }

        return listByTitle;
    }

    List<MediaEntity> findByNoOfDownloads(int min, int max) {
        List<MediaEntity> listByDownloads = new ArrayList<>();
        for (MediaEntity search : holdMedia
        ) {
            if (search.getNoOfDownloads() <= max && search.getNoOfDownloads() >= min) {
                listByDownloads.add(search);
            }

        }
        listByDownloads.sort(MediaEntity::compareTo);
        Collections.sort(listByDownloads, Collections.reverseOrder());
        return listByDownloads;
    }

    void updateDownloads(String title, int downloads) {
        for (int i = 0; i < holdMedia.size(); i++) {
            if (holdMedia.get(i).getTitle().equals(title)) {
                holdMedia.get(i).setNoOfDownloads(downloads);

            }


        }
    }


}
