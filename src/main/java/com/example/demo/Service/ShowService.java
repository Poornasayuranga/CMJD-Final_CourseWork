package com.example.demo.Service;


import com.example.demo.Dto.ShowDto;
import com.example.demo.Entity.Show;
import com.example.demo.Repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    private ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Long id){
        return showRepository.getById(id);
    }

    public Show createShow(ShowDto showDto){

        Show show = new Show();

        show.setTicketPrice(showDto.getTicketPrice());
        show.setShowDate(showDto.getShowDate());
        show.setId(showDto.getId());
        show.setShowTime(showDto.getShowTime());
        show.setMovie(showDto.getMovie());

        return showRepository.save(show);
    }

    public void deleteShowById(final Long id){
        showRepository.deleteById(id);
    }

    public Show updateShow(ShowDto showDto, final Long id){
        Show existingShow = showRepository.getById(id);

            existingShow.setShowTime(showDto.getShowTime());
            existingShow.setShowDate(showDto.getShowDate());
            existingShow.setTicketPrice(showDto.getTicketPrice());

            return showRepository.save(existingShow);

    }

}
