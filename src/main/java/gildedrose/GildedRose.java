package gildedrose;

class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	private void changeQuality(int index, int quality) {
		items[index].quality = items[index].quality + quality;
	}

	private void changeQuality(Item item, int quality) {
		item.quality = item.quality + quality;
	}

	private void changeSellIn(Item item) {
		item.sellIn = item.sellIn -1;
	}

	private void updateItem (Item item) {
		switch(item.name) {
			case "Aged Brie":
				changeQuality(item, 1);
				changeSellIn(item);

		}
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (items[i].quality > 0) {
					if (items[i].name.equals("Conjured Mana Cake")) {
						changeQuality(i, -2);
					} else if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
						changeQuality(i, -1);
					}
				}
			} else {
				if (items[i].quality < 50) {
					changeQuality(i, 1);
					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].sellIn < 11) {
							if (items[i].quality < 50) {
								changeQuality(i, 1);
							}
						}

						if (items[i].sellIn < 6) {
							if (items[i].quality < 50) {
								changeQuality(i, 1);
							}
						}
					}
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
								changeQuality(i, -1);
							}
						}
					} else {
						items[i].quality = 0;
					}
				} else {
					if (items[i].quality < 50) {
						changeQuality(i, 1);
					}
				}
			}
		}
	}
}
