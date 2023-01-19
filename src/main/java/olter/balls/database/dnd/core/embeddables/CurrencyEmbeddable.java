package olter.balls.database.dnd.core.embeddables;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import olter.balls.database.dnd.core.enums.CurrencyTypeEnum;

@Getter
@Setter
@RequiredArgsConstructor
@Embeddable
public class CurrencyEmbeddable {
    private Integer amount;
    @Enumerated(EnumType.STRING)
    private CurrencyTypeEnum currencyType;
}
