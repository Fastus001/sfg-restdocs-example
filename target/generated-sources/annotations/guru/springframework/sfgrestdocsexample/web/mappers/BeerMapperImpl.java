package guru.springframework.sfgrestdocsexample.web.mappers;

import guru.springframework.sfgrestdocsexample.domain.Beer;
import guru.springframework.sfgrestdocsexample.web.model.BeerDto;
import guru.springframework.sfgrestdocsexample.web.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-24T21:54:22+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto BeerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        beerDto.setId( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDto.setVersion( beer.getVersion().intValue() );
        }
        beerDto.setCreatedDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.setBeerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.setBeerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDto.setUpc( beer.getUpc() );
        beerDto.setPrice( beer.getPrice() );

        return beerDto;
    }

    @Override
    public Beer BeerDtoToBeer(BeerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Beer beer = new Beer();

        beer.setId( dto.getId() );
        if ( dto.getVersion() != null ) {
            beer.setVersion( dto.getVersion().longValue() );
        }
        beer.setCreatedDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beer.setLastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beer.setBeerName( dto.getBeerName() );
        if ( dto.getBeerStyle() != null ) {
            beer.setBeerStyle( dto.getBeerStyle().name() );
        }
        beer.setUpc( dto.getUpc() );
        beer.setPrice( dto.getPrice() );

        return beer;
    }
}
