package com.lvdapiaoliang.commodity.adapter.convertor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lvdapiaoliang.commodity.adapter.CommodityProcessor;
import com.lvdapiaoliang.commodity.adapter.convertor.json.PropertyJsonDumper;
import com.lvdapiaoliang.commodity.domain.model.Commodity;
import com.lvdapiaoliang.commodity.domain.model.Property;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

/**
 * @author: lvguopeng
 * @description:
 */
public class CommodityDumper implements CommodityProcessor {

  private PropertyConvertor convertor;
  private OutputStream ostream;
  private ObjectMapper mapper = new ObjectMapper();
  private static byte[] SPLITER = "\n".getBytes(StandardCharsets.UTF_8);

  public CommodityDumper(PropertyConvertor convertor, OutputStream ostream) {
    this.convertor = convertor;
    this.ostream = ostream;
  }

  @Override
  public void onCommodity(Commodity commodity) throws IOException {
    ObjectNode root = mapper.createObjectNode();
    Collection<Property> properties = commodity.getAllProperties();
    for (Property p : properties) {
      ((PropertyJsonDumper) (convertor.dumper(p.getDataType()))).withRoot(root).dump(p);
    }
    ostream.write(root.toString().getBytes(StandardCharsets.UTF_8));
    ostream.write(SPLITER);
  }

}
