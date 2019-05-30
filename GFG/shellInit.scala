/*
* This is an initialization file for the Atlas Shell view. Each time a Shell linked
* with this project is opened or restarted, the code in this file will be run as scala code. Below
* is included the default initialization code for the shell. As long as this file exists only
* the code in this file will be run on shell startup; this default code will not be run if you
* remove it from this file.
* 
* You do not need to put initialization code in a Scala object or class.
* 
*/
import com.ensoftcorp.atlas.core.query.Q
import com.ensoftcorp.atlas.core.xcsg.XCSG
import com.ensoftcorp.atlas.core.db.graph.Graph
import com.ensoftcorp.atlas.core.db.graph.Node
import com.ensoftcorp.atlas.core.db.graph.Edge
import com.ensoftcorp.atlas.core.db.Accuracy._
import com.ensoftcorp.atlas.core.markup.IMarkup
import com.ensoftcorp.atlas.core.markup.Markup
import com.ensoftcorp.atlas.core.markup.MarkupProperty
import java.awt.Color
import com.ensoftcorp.atlas.core.script.Common
import com.ensoftcorp.atlas.core.script.Common._
import com.ensoftcorp.atlas.core.script.CommonQueries
import com.ensoftcorp.atlas.core.script.CommonQueries._
import com.ensoftcorp.atlas.ui.shell.lib.ShellCommon._