# NotePad
---
## 功能添加
* 时间戳显示
* 模糊搜索
* 更改背景颜色
* 更改字体大小
* 夜间模式
* UI美化
***
### 时间戳显示
先更改*notelist_item.xml*文件的布局,关键代码如下:


       <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <TextView
            android:id="@android:id/text1"
            android:layout_width="wrap_content"
            android:layout_height="?android:attr/listPreferredItemHeight"
            android:layout_alignParentRight="true"
            android:layout_alignParentTop="true"
            android:layout_toRightOf="@+id/image_view1"
            android:maxLines="1"
            android:paddingLeft="5dip"
            android:textAppearance="?android:attr/textAppearanceLarge"
            android:textSize="45dp" />
        <ImageView
            android:id="@+id/image_view1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignBottom="@+id/textView"
            android:layout_alignParentLeft="true"
            android:src="@drawable/sp_ic_1" />
        <TextView
            android:id="@+id/tv_time_stamp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentRight="true" />
     </RelativeLayout>


更改时间显示模式，配置适配器，输出时间
 

        Long now = Long.valueOf(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        String nowTime=sdf.format(new Date(now));        
        if (values.containsKey(NotePad.Notes.COLUMN_NAME_CREATE_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_CREATE_DATE, String.valueOf(nowTime));
        }	

```
```

        //更改适配器
        String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE,NotePad.Notes.COLUMN_NAME_CREATE_DATE} ;

        int[] viewIDs = { android.R.id.text1,R.id.tv_time_stamp };
### 运行截图

![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/1.png)

## 模糊搜索
先在*list_options_menu.xml*文件中添加item组件

        <item android:id="@+id/menu_search"
        android:title="search"
        android:showAsAction="always"
        android:icon="@drawable/search_s" />

再在*NotesList.java*中写上功能代码：

     case R.id.menu_search:
              final EditText ets = new EditText(this);
              new AlertDialog.Builder(NotesList.this).setTitle("输入查询").setView(ets)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                input_word = ets.getText().toString();
                                String[] search = {"_id",NotePad.Notes.COLUMN_NAME_TITLE, NotePad.Notes
                                        .COLUMN_NAME_CREATE_DATE};
                                String selection = NotePad.Notes.COLUMN_NAME_TITLE + " like?";
                                String[] selectionArgs = {input_word + "%"};
                                Cursor cursors = managedQuery(getIntent().getData(), search, selection,
                                        selectionArgs, NotePad.Notes.DEFAULT_SORT_ORDER);
                                cursors.moveToFirst();
                                String[] data = {NotePad.Notes.COLUMN_NAME_TITLE, NotePad.Notes
                                        .COLUMN_NAME_CREATE_DATE};
                                final int[] viewID = {android.R.id.text1, R.id.tv_time_stamp};
                                SimpleCursorAdapter adapters = new SimpleCursorAdapter(NotesList
                                        .this, R.layout.noteslist_item, cursors, data, viewID);
                                setListAdapter(adapters);
                            }
                        }).show();
      return true;

### 运行截图

![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/2.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/3.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/4.png)

##更改背景颜色
先在*editor_options_menu.xml*文件中添加新的组件

    <item android:id="@+id/menu_color"
        android:title="change_color">
        <menu>
        <item
            android:id="@+id/color_red"
            android:title="red" />
        <item
            android:id="@+id/color_gold"
            android:title="gold" />
        <item
            android:id="@+id/color_greenyellow"
            android:title="greenyellow" />
        <item
            android:id="@+id/color_lightseagreen"
            android:title="lightseagreen" />
    </menu>
    </item>

再在*NoteEditor.java*文件中写上item的功能代码

    case R.id.color_red:
                mText.setBackgroundColor(getResources().getColor(R.color.red));
                break;
    case R.id.color_gold:
                mText.setBackgroundColor(getResources().getColor(R.color.gold));
                break;
    case R.id.color_greenyellow:
                mText.setBackgroundColor(getResources().getColor(R.color.greenyellow));
                break;
    case R.id.color_lightseagreen:
                mText.setBackgroundColor(getResources().getColor(R.color.lightseagreen));
                break;

选择颜色即可更改背景颜色
### 运行截图

![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/5.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/6.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/7.png)

##更改字体大小
在*editor_options_menu.xml*中添加item，再嵌套一组item

    <item android:id="@+id/menu_change_size"
        android:title="change_size">
        <menu>
            <item android:id="@+id/size_up"
                android:title="size_up" />
            <item android:id="@+id/size_down"
                android:title="size_down" />
        </menu>
    </item>

在*NoteEditor.java*中书写修改字体大小的执行代码

    case R.id.size_up:
            mText.setTextSize(50);
            break;
    case R.id.size_down:
            mText.setTextSize(20);
            break;
### 运行截图

![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/5.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/8.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/9.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/10.png)

## 夜间模式
在*editor_options_menu.xml*中添加夜间模式的item

    <item android:id="@+id/menu_night"
        android:title="night"/>

在*NoteEditor.java*通过修改背景颜色和字体颜色来达到夜间模式的效果

    case R.id.menu_night:
                mText.setBackgroundColor(getResources().getColor(R.color.black));
                mText.setTextColor(getResources().getColor(R.color.gray));
                break;
### 运行截图

![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/5.png)
![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/11.png)

##美化UI
修改了界面显示主题和图标，优化了显示布局。
### 效果截图

![Alt text](https://github.com/ye1831/Homework/blob/master/NotePad/app/src/image/12.png)
