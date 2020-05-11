package ${cfg.ParamCheckUtil};

import com.chinastock.uniplatform.springboot.bean.BaseRequest;
import com.chinastock.uniplatform.springboot.bean.Meta;
import com.chinastock.itesty.common.utils.BaseParamCheck;
import ${package.Entity}.${entity};

public class ParamCheckUtil extends BaseParamCheck {
    public static Meta checkInsertParam(BaseRequest${r"<"}${entity}${r">"} baseRequest) {
        Meta meta = baseCheck(baseRequest);
        if (!meta.isSuccess()) {
            return meta;
        }
        return getNormalMeta();
    }

    public static Meta checkUpdateParam(BaseRequest${r"<"}${entity}${r">"} baseRequest) {
        Meta meta = baseCheck(baseRequest);
        if (!meta.isSuccess()) {
            return meta;
        }
        return getNormalMeta();
    }
}