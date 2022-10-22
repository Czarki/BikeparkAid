package pl.czrmjd.bikeparkaid.service;

import org.springframework.stereotype.Service;
import pl.czrmjd.bikeparkaid.data.entity.OrderEntity;
import pl.czrmjd.bikeparkaid.data.entity.TrainingEntity;
import pl.czrmjd.bikeparkaid.data.repository.OrderRepository;
import pl.czrmjd.bikeparkaid.data.repository.TrainingRepository;
import pl.czrmjd.bikeparkaid.remote.model.TrainingDto;
import pl.czrmjd.bikeparkaid.remote.model.TrainingType;

import java.util.*;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final OrderRepository orderRepository;

    public TrainingService(TrainingRepository trainingRepository, OrderRepository orderRepository) {
        this.trainingRepository = trainingRepository;
        this.orderRepository = orderRepository;
    }

    public List<TrainingDto> getAvailableTrainings(Date dateStart, Date dateEnd, TrainingType type) {

        List<TrainingEntity> trainingEntities = trainingRepository.findAllByType(type.name().toLowerCase());
        for (TrainingEntity te : trainingEntities) {
            System.out.println(te);
        }

        List<TrainingDto> result = new ArrayList<>();

        for (TrainingEntity trainingEntity : trainingEntities) {

            List<OrderEntity> orderEntities = orderRepository.findAllByTrainingId(trainingEntity.getId());

            if (orderEntities.isEmpty()) {

                result.add(new TrainingDto(trainingEntity.getId(), trainingEntity.getName(),
                        TrainingType.valueOf(trainingEntity.getType().toUpperCase()),
                        DateUtils.convertToString(trainingEntity.getDateStart()),
                        DateUtils.convertToString(trainingEntity.getDateEnd()),
                        trainingEntity.getDuration(), trainingEntity.getPrice()));
            } else {

                boolean canAddTraining = true;

                for (OrderEntity orderEntity : orderEntities) {
                    if ((orderEntity.getDateStart().before(dateEnd) && orderEntity.getDateEnd().after(dateStart)) ||
                        (orderEntity.getDateStart().before(dateStart) && orderEntity.getDateEnd().after(dateStart)) ||
                        (orderEntity.getDateStart().before(dateEnd) && orderEntity.getDateEnd().after(dateEnd))) {
//                    nie mozemy dodac poniewaz istnieje zamowienie w tym czasie
                        canAddTraining = false;
                        break;
                    }
            }
                if (canAddTraining) {
                    result.add(new TrainingDto(trainingEntity.getId(), trainingEntity.getName(),
                            TrainingType.valueOf(trainingEntity.getType().toUpperCase()),
                            DateUtils.convertToString(trainingEntity.getDateStart()),
                            DateUtils.convertToString(trainingEntity.getDateEnd()),
                            trainingEntity.getDuration(), trainingEntity.getPrice()));
                }



            }
        }
        return result;
    }

}
